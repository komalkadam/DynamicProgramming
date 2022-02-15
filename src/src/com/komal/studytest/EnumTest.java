/**
 * 
 */
package com.komal.studytest;

import java.util.Arrays;
import java.util.List;

/**
 * @author kkadam
 *
 */
public class EnumTest {
	public static void main(String[] args) {
		List<ProviderType> asList = Arrays.asList(ProviderType.);
		System.out.println(asList.contains("dns"));
	}

}
enum ProviderType {
	aws,
	digitalocean,
	vsphere,
	nsxt,
	azurerm,
	docker,
	google,
	opc,
	helm,
	kubernetes,
	dns,
	hecvm,
	azurestack,
	azuread,
	heccp;
}