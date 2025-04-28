package backend.Enum;

public enum EnumPersonalData {

    CREATED_PATIENT("Paciente criado com sucesso",true),
    PATIENT_NOT_CREATED("Dados existentes ou servidor instável", false),
    PATIENT_EDITED("Paciente alterado com sucesso",true),
    UNEDITED_PATIENT("Paciente não encontrado", false),
    PREVIOUSLY_DISABLED_PATIENT("Anteriormente, paciente já foi desabilitado", false),
    DISABLED_PATIENT("Paciente desabilitado com sucesso", false),
    UNSTABLE_SERVICE("Serviço instável, tente novamente", true);

    private final String description;
    private final boolean active;

    EnumPersonalData(String description, boolean active) {
        this.description = description;
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public boolean getActive() {
        return active;
    }
}
