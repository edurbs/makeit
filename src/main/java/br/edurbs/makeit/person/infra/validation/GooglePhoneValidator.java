package br.edurbs.makeit.person.infra.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.validation.PhoneValidator;

public class GooglePhoneValidator implements PhoneValidator {

    @Override
    public void validate(String numberToValidate) throws DomainEntityValidationException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        PhoneNumber phone;
        try {
            phone = phoneNumberUtil.parse("+55"+numberToValidate, "BR");
            if(!phoneNumberUtil.isValidNumberForRegion(phone, "BR")){
                throw new DomainEntityValidationException("Invalid phone number");
            }
        } catch (NumberParseException e) {
            throw new DomainEntityValidationException("Impossible to parse the phone number");
        }

    }

}
