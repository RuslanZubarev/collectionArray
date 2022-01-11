package practice.hospital;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientTemp = new float[patientsCount];
        float min = 32.0f;
        float max = 40.0f;
        for (int i = 0; i < patientTemp.length; i++) {
            //округление температуры
            patientTemp[i] = (float) Math.round(((Math.random() * ((max - min))) + min) * 10) / 10;
        }
        return patientTemp;
    }

    public static String getReport(float[] temperatureData) {
        //расчет средней температуры
        float averageTemp = 0f;
        if (temperatureData.length > 0) {
            float sum = 0f;
            int i;
            for (i = 0; i < temperatureData.length; i++) {
                sum += temperatureData[i];
            }
            //округление средней температуры
            averageTemp = (float) Math.round((sum / temperatureData.length) * 100) / 100;
        }
        // проверка здоров человек или нет
        float minHtemp = 36.2f; //nim healthy temp
        float maxHtemp = 36.9f;
        int healthyCount = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < temperatureData.length; i++) {
            tmp.append(temperatureData[i] + " ");
            if (temperatureData[i] >= minHtemp && temperatureData[i] <= maxHtemp) {
                healthyCount++;
            }
        }
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */

        String report =
                "Температуры пациентов: " + tmp.substring(0, tmp.length() - 1) +
                        "\nСредняя температура: " + averageTemp +
                        "\nКоличество здоровых: " + healthyCount;

        return report;
    }
}
