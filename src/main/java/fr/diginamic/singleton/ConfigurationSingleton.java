package fr.diginamic.singleton;

import java.util.ResourceBundle;

/**
 * Classe garantissant la création UNIQUE du fichier de configuration.
 * Utilise l'implémentation type holder
 */
public class ConfigurationSingleton {

    private ResourceBundle config;

    // Constructeur privé
    private  ConfigurationSingleton() {
        config = ResourceBundle.getBundle("configuration");
    }

    // Classe interne, n'est chargée que quand getInstance() est appelée
    private static class ConfigurationSingletonHolder {
        private static final ConfigurationSingleton INSTANCE = new ConfigurationSingleton();
    }

    // Méthode d'accès à l'instance unique
    public static ConfigurationSingleton getInstance() {
        return ConfigurationSingletonHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return config.getString("db."+key);
    }
}
