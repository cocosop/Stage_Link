package logone.digital.stagelink.stage;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StageValidator implements Validator {


    public boolean supports(@NotNull Class<?> clazz) {
        return StageDto.class.isAssignableFrom(clazz);
    }


    public void validate(@NotNull Object target, @NotNull Errors errors) {
        StageDto stageDto = (StageDto) target;

        // Validation du nom
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "titre",
                "field.required",
                "Le nom du stage est requis."
        );

        // Validation de la description
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "description",
                "field.required",
                "La description du stage est requise."
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "entreprise",
                "field.required",
                "le nom de l' entreprise est requis."
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "domaine",
                "field.required",
                "le domaine est requis."
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "localisation",
                "field.required",
                "la localisation est requise."
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "dateDebut",
                "field.required",
                "le date de debut est requise."
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "dateFin",
                "field.required",
                "la date de fin est requise."
        );


    }

}
