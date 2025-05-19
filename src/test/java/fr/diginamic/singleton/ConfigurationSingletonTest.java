package fr.diginamic.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    public void testGetInstance() {
        ConfigurationSingleton instance = ConfigurationSingleton.getInstance();

        assertEquals("jdbc:mysql://localhost:3306/mabase", instance.getProperty("url"));
        assertEquals("root", instance.getProperty("user"));
        assertEquals("1234", instance.getProperty("password"));
    }

    @Test
    public void testSingletonInstanceIsUnique() {
        ConfigurationSingleton config1 = ConfigurationSingleton.getInstance();
        ConfigurationSingleton config2 = ConfigurationSingleton.getInstance();

        assertSame(config1, config2, "Les deux instances doivent être identiques (singleton)");
    }

    @Test
    public void testPropertyNotFoundThrowsException() {
        ConfigurationSingleton config = ConfigurationSingleton.getInstance();

        assertThrows(java.util.MissingResourceException.class, () -> {
            config.getProperty("clé.inexistante");
        });
    }
}
