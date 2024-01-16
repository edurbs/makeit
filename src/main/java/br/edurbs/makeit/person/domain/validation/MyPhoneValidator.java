package br.edurbs.makeit.person.domain.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

public class MyPhoneValidator implements PhoneValidator {

    @Override
    public void validate(String phone) throws DomainEntityValidationException {
        String onlyNumbers = phone.replaceAll("\\D", "");
        if (onlyNumbers.isBlank()
                || isInvalidLength(onlyNumbers)
                || isInvalidMobileStartNumber(onlyNumbers)
                || isAllTheSameNumber(onlyNumbers)
                || isInvalidDddBrazilCode(onlyNumbers)
                || isInvalidBrazilCngNumber(onlyNumbers)
                || isInvalidSpecialBrazilMobileNumber(onlyNumbers)
                || isInvalidNonMobileNumber(onlyNumbers)){
            throw new DomainEntityValidationException("Invalid phone number");
        }
    }

    private boolean isInvalidBrazilCngNumber(String onlyNumbers) {
        String prefix = onlyNumbers.substring(0, 4);
        // https://www.gov.br/anatel/pt-br/regulado/numeracao/tabela-servico-telefonico-fixo-comutado-codigos-nao-geograficos-cng
        Set<String> prefixCng = new HashSet<>(
                Arrays.asList("0800", "0300", "0500", "0900"));
        return onlyNumbers.length() == 11 && onlyNumbers.startsWith("0") && !prefixCng.contains(prefix);
    }

    private boolean isInvalidSpecialBrazilMobileNumber(String onlyNumbers) {
        // https://www.gov.br/anatel/pt-br/regulado/numeracao/tabela-servico-movel-especializado
        int areaCode = Integer.parseInt(onlyNumbers.substring(0, 2));
        int prefix = Integer.parseInt(onlyNumbers.substring(2, 4));
        return (prefix == 70 || (prefix >= 77 && prefix <= 79))
            && !(
                ((areaCode >= 11 && areaCode <= 19) && (prefix == 70 || (prefix >= 77 && prefix <= 79)))
                || ((areaCode==21 || areaCode==22 || areaCode==24) && (prefix==70 || prefix == 77 || prefix == 78))
                || ((areaCode == 31 || areaCode == 34 || areaCode == 37) && (prefix == 77 || prefix == 78))
                || (((areaCode == 27 || areaCode==47 || areaCode==48 || areaCode==51 || areaCode==54 || areaCode == 61 || areaCode==62 || areaCode==65 || areaCode==71 || areaCode==73 || areaCode==75 || areaCode==81 || areaCode==85) || (areaCode >= 41 && areaCode <= 44)) && prefix == 78));
    }

    private boolean isInvalidNonMobileNumber(String onlyNumbers) {
        Set<Integer> nonMobilePrefix = new HashSet<>(Arrays.asList(2, 3, 4, 5, 7));
        return (onlyNumbers.length() == 10
                && !nonMobilePrefix.contains(Integer.parseInt(onlyNumbers.substring(2, 3))));
    }

    private boolean isInvalidDddBrazilCode(String onlyNumbers) {
        Set<Integer> validDddBrazilCodes = new HashSet<>(
                Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 31, 32, 33,
                        34, 35, 37, 38, 41, 42, 43, 44, 45, 46, 47, 48, 49, 51, 53, 54, 55, 61, 62, 64, 63,
                        65, 66, 67, 68, 69, 71, 73, 74, 75, 77, 79, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91,
                        92, 93, 94, 95, 96, 97, 98, 99));
        return isInvalidBrazilCngNumber(onlyNumbers) && !(validDddBrazilCodes.contains(Integer.parseInt(onlyNumbers.substring(0, 2))));
    }

    private boolean isAllTheSameNumber(String onlyNumbers) {
        Pattern regexPattern =
                Pattern.compile(onlyNumbers.charAt(0) + "{" + onlyNumbers.length() + "}");
        Matcher matchAllSameNumbers = regexPattern.matcher(onlyNumbers);
        return matchAllSameNumbers.find();
    }

    private boolean isInvalidMobileStartNumber(String onlyNumbers) {
        String subprefix = onlyNumbers.substring(2, 3);
        return onlyNumbers.length() == 11 && !subprefix.equals("9") && !subprefix.equals("0");
    }

    private boolean isInvalidLength(String onlyNumbers) {
        return !(onlyNumbers.length() >= 10 && onlyNumbers.length() <= 11);
    }

}
