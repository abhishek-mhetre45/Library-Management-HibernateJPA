public class HibernateConfig {
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("libraryPU");
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}