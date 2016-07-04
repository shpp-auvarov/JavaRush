package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider[] providers) {
        if (providers.length == 0 || view == null) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
        List<Vacancy> result = new ArrayList<>();
        for (Provider provider : providers) {
            result.addAll(provider.getJavaVacancies(city));
        }
        view.update(result);
    }
}