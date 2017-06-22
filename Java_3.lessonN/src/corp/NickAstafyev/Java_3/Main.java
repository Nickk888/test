package corp.NickAstafyev.Java_3;


public class Main {

    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        TestClass testClass = new TestClass();
        testClass.setN(100);
        TestConnect testConnect = new TestConnect();
        StaxWriteExample staxWriteExample = new StaxWriteExample();
        XLSTTransform xlstTransform = new XLSTTransform();
        Pars2xml pars2xml = new Pars2xml();

        try {
            testConnect.connect();//установка соединения
            testConnect.dropTableEx();//удаление табл.
            testConnect.createTableEx();//создание табл TEST столбец FIELD
            testConnect.psCon((int) testClass.getN());//закидываем в табл.TEST столбец FIELD с 1 по N
            staxWriteExample.mn();//запрос в TEST.FIELD и формирование XML док.
            xlstTransform.transform();// XLST преобразует в 2.xml
            pars2xml.parsXmlSum();// парсит 2.xml и выводит сумму знчений в консоль
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            testConnect.disconnect();// Разъединение
        }
        System.out.print("общее время работы: ");
        System.out.println(System.currentTimeMillis() - t);
    }

}
