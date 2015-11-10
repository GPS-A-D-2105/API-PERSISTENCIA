/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.evalpro.dao.jpa;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Luis Daniel
 */
public class TestRunnerApiBD {

    public static String listaExcepciones(){
        Result result = JUnitCore.runClasses(TestJunitApiBD.class);
        String resultadoExcepciones = "";
        for (Failure failure : result.getFailures()) {
            resultadoExcepciones += failure.toString();
            System.out.println(failure.toString());
            resultadoExcepciones += failure.getException();
            System.out.println(failure.getException());
            resultadoExcepciones += failure.getTestHeader();
            System.out.println(failure.getTestHeader());
        }
        resultadoExcepciones += result.wasSuccessful();
        System.out.println(result.wasSuccessful());
        return resultadoExcepciones;
    }
}
