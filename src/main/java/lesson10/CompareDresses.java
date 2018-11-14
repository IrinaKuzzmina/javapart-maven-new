package lesson10;

import automationpractice.model.EntityDress;

import java.util.Arrays;
import java.util.Arrays;


    public class CompareDresses {
        public static void main(String[] args) {
            String[] expectedModels = {"demo_2", "demo_1", "demo_3", "demo_4"};
            String[] actualModels = {"demo_3", "demo_4", "demo_1", "demo_5"};

            EntityDress[] expectedDresses = getExpectedDresses();
            EntityDress[] actualDresses = getActualDresses();
            boolean assertByModel = compare(expectedModels, actualModels);
            boolean assertByDress = compare(expectedDresses, actualDresses);

            // Input Detail Report
            System.out.println("Expected models: ");
            System.out.println("Actual models: ");
            System.out.println("Comparing: " + assertByModel);

            System.out.println("Expected dresses: ");
            System.out.println("Actual dresses: ");
            System.out.println("Comparing: " + assertByDress);
        }

        private static boolean compare(String[] expected, String[] actual) {
            // Сортируются и оригинальные массивы, так как передаются по ссылке
            Arrays.sort(expected);
            Arrays.sort(actual);
            return Arrays.equals(expected, actual);
        }

        private static boolean compare(EntityDress[] expected, EntityDress[] actual) {
            // Для того, чтобы сортировка отработала, необходимо реализовать
            // интерфейс 'Comparable' для элементов 'EntityDress'
            Arrays.sort(expected);
            Arrays.sort(actual);
            return Arrays.equals(expected, actual);
        }

        public static EntityDress[] getExpectedDresses() {
            return new EntityDress[]{
                    new EntityDress()
                            .withModel("demo_2")
                            .withName("Faded Short Sleeve T-shirts")
                            .withColor("Orange")
                            .withSize("S")
                            .withPrice(16.51),

                    new EntityDress()
                            .withModel("demo_1")
                            .withName("Printed Dress")
                            .withColor("Orange")
                            .withSize("S")
                            .withPrice(26.00),

                    new EntityDress()
                            .withModel("demo_3")
                            .withName("Printed Dress")
                            .withColor("Beige")
                            .withSize("S")
                            .withPrice(50.99),

                    new EntityDress()
                            .withModel("demo_4")
                            .withName("Printed Summer Dress")
                            .withColor("Yellow")
                            .withSize("S")
                            .withPrice(28.98),
            };
        }

        public static EntityDress[] getActualDresses() {
            return new EntityDress[]{
                    new EntityDress()
                            .withModel("demo_3")
                            .withName("Printed Dress")
                            .withColor("Orange")
                            .withSize("S")
                            .withPrice(26.00),

                    new EntityDress()
                            .withModel("demo_4")
                            .withName("Printed Dress")
                            .withColor("Beige")
                            .withSize("S")
                            .withPrice(50.99),

                    new EntityDress()
                            .withModel("demo_1")
                            .withName("Faded Short Sleeve T-shirts")
                            .withColor("Orange")
                            .withSize("S")
                            .withPrice(16.51),

                    new EntityDress()
                            .withModel("demo_5")
                            .withName("Printed Summer Dress")
                            .withColor("Yellow")
                            .withSize("S")
                            .withPrice(28.98),
            };
        }
    }

