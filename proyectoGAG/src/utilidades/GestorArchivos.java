package utilidades;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class GestorArchivos {	
	private static final String CARPETA_SUBIDAS = "juguetes";
	
	public static String rutaArchivo(int id){
		String ruta = CARPETA_SUBIDAS+File.separator+id+".jpg";
		//como estamos trabajando en local, para ver los resultados
		//debo dar rutas absolutas
		File f = new File(ruta);		
		return f.getAbsolutePath();
	}
	
	//metodo que sobre un archivo subido le asigna una ruta
	public static void guardarArchivo(Part archivo, String ruta){
		if(archivo == null){
			System.out.println("no hay archivo,no guardo imagen");
			return;
		}
		File carpetaSubidas = new File(CARPETA_SUBIDAS);
		if(!carpetaSubidas.exists()){
			carpetaSubidas.mkdir();
		}
		try {
			InputStream is = archivo.getInputStream();
			FileOutputStream fos = new FileOutputStream(CARPETA_SUBIDAS+File.separator+ruta);
			byte[] leidos = new byte[1024];
			while((is.read(leidos))!=-1){
				fos.write(leidos);
			}
			fos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end guardarArchivo

	public static void borrarArchivo(int id) {
		String rutaFoto = rutaArchivo(id);
		File foto = new File(rutaFoto);
	    if (foto.delete())
	        System.out.println("La foto ha sido borrada");
	    else
	        System.out.println("La foto no se pudo borrar");
	}
}//end class
