package com.anz.platform.util;

import static com.anz.platform.util.Constants.NOT_EMPTY;
import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public final class ZipUtil {

  private ZipUtil() {
    throw new UnsupportedOperationException();
  }

  public static void createZip(String zipPath, ArrayList<File> files, String password) throws ZipException {
    ObjectUtils.notEmpty(zipPath, String.format(NOT_EMPTY, "ZipPath"));
    ObjectUtils.notEmpty(files, String.format(NOT_EMPTY, "File items"));
    ObjectUtils.notEmpty(password, String.format(NOT_EMPTY, "RandomPassword"));

    ZipFile zipFile = new ZipFile(zipPath);
    ZipParameters parameters = new ZipParameters();
    parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
    parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
    if (ObjectUtils.isNotEmpty(password)) {
      parameters.setEncryptFiles(true);
      parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
      parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
      parameters.setPassword(password);
    }
    zipFile.addFiles(files, parameters);
  }
}
