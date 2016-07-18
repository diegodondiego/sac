/**
 *
 */
package br.issgc.sac.persistence.constants;

/**
 * Represents all Brazil's states
 *
 * @author dinhego
 *
 */
public enum BrazilStates {

	AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA("Bahia"), CE("Ceará"), DF("Distrito Federal"), ES("Espírito Santo"), GO("Goiás"),
	MA("Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG("Minas Gerais"), PA("Pará"), PB("Paraíba"), PR("Paraná"), PE("Pernambuco"),
	PI(" Piauí"), RJ("Rio	de Janeiro"), RN("Rio Grande do Norte"), RS("Rio Grande do Sul"), RO("Rondônia"), RR("Roraima"), SC("Santa Catarina"), 
	SP("São Paulo"), SE("Sergipe"), TO("Tocantins");

	private String fullName;

	/**
	 *
	 * @param fullName
	 */
	BrazilStates(String fullName) {
		this.fullName = fullName;
	}

	public String fullName() {
		return this.fullName;
	}
}
