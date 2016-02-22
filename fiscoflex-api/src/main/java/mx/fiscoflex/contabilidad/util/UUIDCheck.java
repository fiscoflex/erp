package mx.fiscoflex.contabilidad.util;

public class UUIDCheck {

	public static boolean isUUID(String uuid) {
		return uuid.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}");
	}
}
