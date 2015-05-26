package be.acuzio.mrta.test;

import be.acuzio.mrta.BuildConfig;

public final class CustomBuildConfig {
    public static final boolean DEBUG = BuildConfig.DEBUG;
    public static final String APPLICATION_ID = BuildConfig.class.getPackage().getName();
    public static final String BUILD_TYPE = BuildConfig.BUILD_TYPE;
    public static final String FLAVOR = BuildConfig.FLAVOR;
    public static final int VERSION_CODE = BuildConfig.VERSION_CODE;
    public static final String VERSION_NAME = BuildConfig.VERSION_NAME;
}
