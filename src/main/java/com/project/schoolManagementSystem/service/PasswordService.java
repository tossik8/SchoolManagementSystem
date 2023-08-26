package com.project.schoolManagementSystem.service;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    public String generatePassword(){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars, 3);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars, 3);

        CharacterData digits = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digits, 2);

        CharacterData specialChars = new CharacterData() {
            @Override
            public String getErrorCode() {
                return null;
            }

            @Override
            public String getCharacters() {
                return "$%@*.?!_#";
            }
        };
        CharacterRule specialCharsRule = new CharacterRule(specialChars, 2);
        return passwordGenerator.generatePassword(10, lowerCaseRule, upperCaseRule, digitRule, specialCharsRule);
    }
}
