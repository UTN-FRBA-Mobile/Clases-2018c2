package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.fileSystem

import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ExternalStorage {
    companion object {
        fun getFileUri(fileName: String): String? {
            val file = File(getAppFolder() + fileName)
            if (file.exists()) {
                return file.toURI().toString()
            }
            return null
        }

        fun saveFile(bitmap: Bitmap, fileName: String) : File {
            val file = File(getAppFolder() + fileName)
            try {
                file.createNewFile()
                val ostream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, ostream)
                ostream.flush()
                ostream.close()
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage)
            }

            return file
        }

        fun deleteFile(fileName: String) {
            val file = File(getAppFolder() + fileName)
            if (file.exists()) {
                file.delete()
            }
        }

        fun getCacheFileUri(context: Context, fileName: String): String? {
            val file = File(context.externalCacheDir.path + fileName)
            if (file.exists()) {
                return file.toURI().toString()
            }
            return null
        }

        fun saveFileInCache(context: Context, bitmap: Bitmap, fileName: String) : File {
            val file = File(context.externalCacheDir.path + fileName)
            try {
                file.createNewFile()
                val ostream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, ostream)
                ostream.flush()
                ostream.close()
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage)
            }

            return file
        }

        fun deleteFileFromCache(context: Context, fileName: String) {
            val file = File(context.externalCacheDir.path + fileName)
            if (file.exists()) {
                file.delete()
            }
        }

        private fun getAppFolder(): String {
            val folder = File(Environment.getExternalStorageDirectory().path + "/clases_2018c1/")
            if(!folder.exists()){
                folder.mkdirs()
            }

            return Environment.getExternalStorageDirectory().path + "/clases_2018c1/"
        }
    }
}