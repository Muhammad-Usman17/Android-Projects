package com.example.muhammad_usman.caesarcipher;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void app_isCorrect() throws Exception {
        Endec d=new Endec();
        String name="USMAN";

        int key=4;
        assertEquals(d.decipher(d.encipher(name,key),key),name);


    }

}