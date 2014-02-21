import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class coba implements lat

{
	public static void main(String... args)
	{
		try {

			//Meregistrikan suatu class kedalam  project
			Class<?> c = Class.forName("javax.swing.JFrame");
			System.out.println("\n Nama Classnya: " + c.getName());
			System.out.println(" \n \n Type Modifiersnya: "
					+ Modifier.toString(c.getModifiers()));

			out.format("\n Implemented Interfaces: ");
			Type[] intfs = c.getGenericInterfaces();
			if (intfs.length != 0) {
				for (Type intf : intfs)
					out.format("  %s%n", intf.toString());
				out.format("%n");
			} else {
				out.format("  -- No Implemented Interfaces --%n%n");
			}

			//mencetak semua method yang ada di dalam classnya
			Method m[] = c.getDeclaredMethods();
			for (Method method : m) {
				//mencetak nama semua methodnya
				System.out.println("  " + method.getName());

			}
			//mencetak semua atributnya
			System.out.println("\n Fieldnya adalah sebagai berikut:");
			//membuat array yang beratribut Field
			Field atribut[] = c.getDeclaredFields();

			//cek Kondisi apaka atributnya ada atau tidak
			if (atribut.length == 0) {
				System.out.println(" Tidak ada atribut yang di deklarasikan");
			} else {
				for (Field field : atribut) {
					System.out
							.println(field.getType() + "  " + field.getName());
				}
			}

			System.out.println(" \n Inheritance Path: ");
			List<Class> l = new ArrayList<Class>();
			cetakSuperClassnya(c, l);
			if (l.size() != 0) {
				for (Class<?> cl : l)
					out.format("  %s%n", cl.getCanonicalName());
				out.format("%n");
			} else {
				out.format("  -- No Super Classes --%n%n");
			}

			// production code should handle this exception more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	private static void cetakSuperClassnya(Class<?> c, List<Class> l)
	{
		Class<?> ancestor = c.getSuperclass();
		if (ancestor != null) {
			l.add(ancestor);
			cetakSuperClassnya(ancestor, l);
		}
	}

	public void cetak_apa()
	{
		System.out.println("belajar mencetak Interface");
	}
}

interface lat
{
	void cetak_apa();
}
