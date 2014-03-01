disemvoweller
=============

Reddit Daily Programmer #149

Disemvoweling means removing the vowels from text. (For this challenge, the letters a, e, i, o, and u are considered vowels, and the letter y is not.) The idea is to make text difficult but not impossible to read, for when somebody posts something so idiotic you want people who are reading it to get extra frustrated.

To make things even harder to read, we'll remove spaces too. For example, this string:

`two drums and a cymbal fall off a cliff`

can be disemvoweled to get:

`twdrmsndcymblfllffclff`

We also want to keep the vowels we removed around (in their original order), which in this case is:

`ouaaaaoai`

reemvoweller
============

Reddit Daily Programmer #150

In this week's Easy challenge, series of words were disemvoweled into vowels, and non-vowel letters. Spaces were also removed. Your task today is, given the two strings produced via disemvowelment, output one possibility for the original string.

   * Your output must be such that if you put it through the solution to this week's Easy challenge, you'll recover exactly the input you were given.
   * You don't need to output the same string as the one that was originally disemvoweled, just some string that disemvowels to your input.
   * Use the Enable word list, or some other reasonable English word list. Every word in your output must appear in your word list.
   * For the sample inputs, all words in originally disemvoweled strings appear in Enable. In particular, I'm not using any words with punctuation, and I'm not using the word "a".
   * As before, ignore punctuation and capitalization.

Input description

Two strings, one containing only non-vowel letters, and one containing only vowels.
Output description

A space-separated series of words that could be disemvoweled into the input, each word of which must appear in your word list. 



