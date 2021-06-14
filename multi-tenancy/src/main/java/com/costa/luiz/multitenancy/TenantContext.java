package com.costa.luiz.multitenancy;

/**
 * This class is to guarantee the representation of Tenant
 */
public abstract class TenantContext {
    public static final String DEFAULT_TENANT_ID = "public";
    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static boolean setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
        return true;
    }

    public static void clear() {
        currentTenant.remove();
    }
}
