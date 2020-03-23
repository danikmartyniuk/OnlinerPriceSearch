package utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CSVUtils {

    public static void writeStatsToCSV (String fileName, OnlinerStats newStats) {

        CsvMapper csvMapper = new CsvMapper();
        //Устанавливаем разделитель между колонок
        CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
        //Создаем reader, способный вычитать сразу объекты класса OnlinerStats
        ObjectReader oReader = csvMapper.readerWithSchemaFor(OnlinerStats.class).with(schema);
        //Лист объектов, которые в будущем планируем записать в конечный файл
        ArrayList<OnlinerStats> statsToWrite = new ArrayList<>();
        System.out.println(String.format("Открываем файл для чтения/записи: %s", fileName));
        try (Reader reader = new FileReader(fileName)) {
            // Флаг для определения того, что дата дублируется
            boolean isDateDuplicated = false;
            MappingIterator<OnlinerStats> mi = oReader.readValues(reader);
            //Вычитываем каждый ряд из файла как объект
            while (mi.hasNext()) {
                OnlinerStats currentRowStat = mi.next();
                //Если дата новой статистики совпадает с датой, которая уже есть в файле - перезаписываем объект
                if(currentRowStat.getDate().equals(newStats.getDate())) {
                    System.out.println(String.format("Запись за указанную дату уже сущестуует, перезаписываем. Было: %s \n Стало: %s",
                            currentRowStat, newStats));
                    currentRowStat = newStats;
                    isDateDuplicated = true;

                }
                statsToWrite.add(currentRowStat);
            }
            //Если дубликата не нашли - то просто добавляем в коллекцию еще один новый ряд
            if(!isDateDuplicated) {
                statsToWrite.add(newStats);
                System.out.println(String.format("Дописываем дополнительный ряд со статистикой в CSV файл: %s", newStats));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Созданием механизм для записи объектов/коллекций в CSV файл
        schema = csvMapper.schemaFor(OnlinerStats.class).withColumnSeparator(';').withHeader();
        ObjectWriter writer = csvMapper.writer(schema.withLineSeparator("\n"));
        //Пишем в файл
        try {
            writer.writeValue(
                    new File(fileName), statsToWrite);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Exception while Writing full CSV report. Details: " + e);
        }
    }

}
