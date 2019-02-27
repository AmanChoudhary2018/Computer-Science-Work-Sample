import java.util.Scanner;


/**
 * Converts english to pig latin and vice versa.
 * 
 * @author Aman Choudhary
 * @version 10/18/18
 * 
 * @author Period - 4
 * @author Assignment - ???
 * 
 * @author Sources - none
 */
public class PiglatinAnalyzer
{
    private String text;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        int length = phraseToTranslate.length();
        String currentWord;
        int indexOfSpace = 0;
        boolean isTrue = true;

        for ( int index = 0; index <= length - 1; index = indexOfSpace + 1 )
        {
            while ( Character.isLetter( 
                ( phraseToTranslate.charAt( index ) ) ) == false )
            {
                if ( index == length - 1 )
                {
                    translation += phraseToTranslate.charAt( index );
                    return translation;
                }
                translation += phraseToTranslate.charAt( index );
                index++;
            }

            currentWord = extractWord( index );

            while ( index <= length - 1  )
            {
                if ( Character.isLetter( ( 
                                phraseToTranslate.charAt( index ) ) ) == false )
                {
                    indexOfSpace = index;
                    translation += wordToPigLatin( currentWord );
                    translation += phraseToTranslate.charAt( index );
                    isTrue = false;
                    break;
                }

                else if ( phraseToTranslate.
                                charAt( index ) == ' ')
                {
                    isTrue = true;
                    indexOfSpace = index;
                    break;
                }
                
                else if(index == length - 1 )
                {
                    translation += wordToPigLatin( currentWord );
                    return translation;
                }

                index++;
            }
            

            if ( isTrue )
            {
                translation += wordToPigLatin( currentWord ) + " ";
            }
            

        }
 
        return translation;

    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";
        String lowercase = englishWord.toLowerCase();
        int length = englishWord.length();

        for ( int index = 0; index <= length - 1; index++ )
        {
            if ( lowercase.charAt( index ) == 'a' 
                            || lowercase.charAt( index ) == 'e'
                || lowercase.charAt( index ) == 'i' 
                || lowercase.charAt( index ) == 'o'
                || lowercase.charAt( index ) == 'u' )
            {

                if ( index == 0 )
                {
                    if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
                    {
                        pigLatinWord = lowercase + "yay";

                        pigLatinWord = pigLatinWord.substring
                                        ( 0, 1 ).toUpperCase()
                            + pigLatinWord.substring( 1 );

                        return pigLatinWord;
                    }
                    else
                    {
                        return pigLatinWord = lowercase + "yay";
                    }
                }

                else
                {
                    String start = lowercase.substring( 0, index );
                    String end = lowercase.substring( index );

                    if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
                    {
                        pigLatinWord = end + start + "ay";

                        pigLatinWord = pigLatinWord.substring( 0, 1 )
                                        .toUpperCase()
                            + pigLatinWord.substring( 1 );

                        return pigLatinWord;
                    }
                    else
                    {
                        return pigLatinWord = end + start + "ay";
                    }

                }

            }

        }

        if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
        {
            pigLatinWord = englishWord + "ay";

            pigLatinWord = pigLatinWord.substring( 0, 1 ).toUpperCase()
                + pigLatinWord.substring( 1 );

            return pigLatinWord;
        }
        else
        {
            return pigLatinWord = englishWord + "ay";

        }
    }


    public String extractWord( int pos )
    {
        String result = "";
        int length = text.length();

        int initialIndex = pos;
        int endIndex = pos;

        while ( initialIndex >= 0 && Character.
                        isLetter( text.charAt( initialIndex ) ) )
        {
            initialIndex = initialIndex - 1;
        }

        while ( endIndex < length - 1 && Character.
                        isLetter( text.charAt( endIndex ) ) )
        {
            endIndex++;
        }

        if ( endIndex == length - 1 && Character.
                        isLetter( text.charAt( endIndex ) ) )
        {
            endIndex++;
        }

        result = text.substring( initialIndex + 1, endIndex );

        return result;
    }
}
