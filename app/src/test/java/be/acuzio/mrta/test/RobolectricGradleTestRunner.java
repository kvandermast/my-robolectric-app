package be.acuzio.mrta.test;


import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.FileFsFile;
import org.robolectric.res.FsFile;

public class RobolectricGradleTestRunner extends RobolectricTestRunner {

    public RobolectricGradleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);


    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        AndroidManifest manifest = super.getAppManifest(config);

        FsFile androidManifestFile = manifest != null ? manifest.getAndroidManifestFile() : null;

        if (null != androidManifestFile && androidManifestFile.exists()) {
            return manifest;
        }

        String moduleRoot = getModuleRootPath(config);

        androidManifestFile = FileFsFile.from(moduleRoot, "src/main/AndroidManifest.xml");
        FsFile resDir = FileFsFile.from(moduleRoot, "src/main/res");
        FsFile assetsDir = FileFsFile.from(moduleRoot, "src/main/assets");

        return new AndroidManifest(androidManifestFile, resDir, assetsDir, "be.acuzio.mrta");
    }


    private String getModuleRootPath(Config config) {
        String moduleRoot = config.constants().getResource("").toString().replace("file:", "");
        return moduleRoot.substring(0, moduleRoot.indexOf("/build"));

    }
}