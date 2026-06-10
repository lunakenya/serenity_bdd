package com.demoblaze.utils;

import com.demoblaze.models.PurchaseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utilidad para construir los datos de prueba desde el archivo de propiedades externas.
 * Centraliza la carga de datos para que los StepDefinitions no tengan datos hardcodeados.
 */
public class TestDataBuilder {

    private static final Logger log = LoggerFactory.getLogger(TestDataBuilder.class);
    private static final String PROPERTIES_FILE = "testdata/purchase-data.properties";
    private static Properties properties;

    static {
        loadProperties();
    }

    private TestDataBuilder() {
        // Clase utilitaria — no instanciar
    }

    /**
     * Carga el archivo de propiedades desde el classpath.
     */
    private static void loadProperties() {
        properties = new Properties();
        try (InputStream is = TestDataBuilder.class
                .getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE)) {
            if (is == null) {
                throw new IllegalStateException(
                        "No se encontró el archivo de datos de prueba: " + PROPERTIES_FILE);
            }
            properties.load(is);
            log.info("Datos de prueba cargados desde: {}", PROPERTIES_FILE);
        } catch (IOException e) {
            throw new IllegalStateException("Error al leer el archivo de datos de prueba", e);
        }
    }

    /**
     * Construye un objeto PurchaseData con los datos del archivo de propiedades.
     *
     * @return PurchaseData completo con los datos externalizados
     */
    public static PurchaseData buildPurchaseData() {
        return new PurchaseData.Builder()
                .withBuyerName(get("purchase.buyer.name"))
                .withCountry(get("purchase.buyer.country"))
                .withCity(get("purchase.buyer.city"))
                .withCardNumber(get("purchase.buyer.card"))
                .withMonth(get("purchase.buyer.month"))
                .withYear(get("purchase.buyer.year"))
                .build();
    }

    /**
     * Retorna el nombre del primer producto configurado.
     *
     * @return nombre del primer producto
     */
    public static String getProduct1() {
        return get("purchase.product1");
    }

    /**
     * Retorna el nombre del segundo producto configurado.
     *
     * @return nombre del segundo producto
     */
    public static String getProduct2() {
        return get("purchase.product2");
    }

    /**
     * Accede de forma segura a una propiedad del archivo.
     *
     * @param key clave de la propiedad
     * @return valor de la propiedad
     */
    private static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Propiedad requerida no encontrada o vacía en " + PROPERTIES_FILE + ": " + key);
        }
        return value.trim();
    }
}
