package be.acuzio.mrta.test;


import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

public class RobolectricGradleTestRunner extends RobolectricTestRunner {

    public RobolectricGradleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);


    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        String manifestProperty = System.getProperty("android.manifest");
        AndroidManifest manifest;


        if (config.manifest().equals(Config.DEFAULT) && manifestProperty != null) {
            String resProperty = System.getProperty("android.resources");
            String assetsProperty = System.getProperty("android.assets");

            manifest = new AndroidManifest(Fs.fileFromPath(manifestProperty), Fs.fileFromPath(resProperty),
                    Fs.fileFromPath(assetsProperty));

        } else {

            String myAppPath = RobolectricGradleTestRunner.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .getPath();

            String manifestPath = myAppPath + "../../../src/main/AndroidManifest.xml";
            String resPath = myAppPath + "../../../src/main/res";
            String assetPath = myAppPath + "../../../src/main/assets";

            manifest = createAppManifest(Fs.fileFromPath(manifestPath), Fs.fileFromPath(resPath), Fs.fileFromPath(assetPath));
        }

        return manifest;
    }


}