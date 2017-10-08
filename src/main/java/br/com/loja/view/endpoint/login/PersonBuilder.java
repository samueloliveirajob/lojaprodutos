package br.com.loja.view.endpoint.login;

/**
 * Created by STELO\renato.5a on 9/19/17.
 */
public final class PersonBuilder {
    private String cnpj;
    private String cpf;
    private String email;
    private String id;
    private String name;
    private String profiles;
    private String relationshipId;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public PersonBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PersonBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withProfiles(String profiles) {
        this.profiles = profiles;
        return this;
    }

    public PersonBuilder withRelationshipId(String relationshipId) {
        this.relationshipId = relationshipId;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setCnpj(cnpj);
        person.setCpf(cpf);
        person.setEmail(email);
        person.setId(id);
        person.setName(name);
        person.setProfiles(profiles);
        person.setRelationshipId(relationshipId);
        return person;
    }
}
