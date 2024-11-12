package org.lopertut.appHelpers;

import org.lopertut.models.Toy;
import org.lopertut.interfaces.AppHelper;
import org.lopertut.interfaces.Input;
import java.util.List;
import java.util.UUID;


public class ToyAppHelper implements AppHelper<Toy>, Input {

    @Override
    public Toy create() {
        Toy toy = new Toy();
        System.out.print("Название игрушки: ");
        toy.setName(getString());

        System.out.print("Укажите количество материалов: ");
        int countMaterials = Integer.parseInt(getString());
        for (int i = 0; i < countMaterials; i++) {
            System.out.printf("Введите название материала (%d из %d): ", i + 1, countMaterials);
            String material = getString();
            toy.getMaterials().add(material);
        }

        System.out.print("Рекомендуемый возраст: ");
        toy.setRecommendedAge(Integer.parseInt(getString()));

        System.out.print("Цена игрушки: ");
        toy.setPrice(Integer.parseInt(getString()));

        return toy;
    }

    @Override
    public boolean printList(List<Toy> toys) {
        if (toys == null || toys.isEmpty()) {
            System.out.println("Список игрушек пуст.");
            return false;
        }
        StringBuilder sbToys = new StringBuilder();
        for (int i = 0; i < toys.size(); i++) {
            Toy toy = toys.get(i);
            if (toy == null) { continue; }
            StringBuilder sbMaterialsToy = new StringBuilder();
            for (String material : toy.getMaterials()) {
                if (material != null) {
                    sbMaterialsToy.append(material).append(" ");
                }
            }
            sbToys.append(String.format("%d. %s. Материалы: %s. Рекомендуемый возраст: %d. Цена: %s%n",
                    i + 1,
                    toy.getName(),
                    sbMaterialsToy.toString().trim(),
                    toy.getRecommendedAge(),
                    toy.getPrice()
            ));
        }
        System.out.println(sbToys);
        return true;
    }


    public boolean delete(List<Toy> toys) {
        if (toys == null || toys.isEmpty()) {
            return false;
        }


    }
}