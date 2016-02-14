package my.RSLogix.L5X.TagBeans;

public class ControllerBaseTagBean extends GenericTagBean
{
	private static final long serialVersionUID = 8190087634064126821L;

	public ControllerBaseTagBean() { super(); }

	public ControllerBaseTagBean(String tagName, String rootDataType,
			String aliasFor, String dataType, String tagType, String radix,
			String constant, String externalAccess)
	{
		super(tagName, rootDataType, aliasFor, dataType, tagType, radix, constant, externalAccess);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
