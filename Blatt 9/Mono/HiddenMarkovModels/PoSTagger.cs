
using System;
using System.IO;

namespace HiddenMarkovModels
{
    public class PoSTagger
    {
        private TagDictionary markovChains = new TagDictionary();
        private TagDictionary wordsForTags = new TagDictionary();

        private PoSTagger()
        {
        }

        public static PoSTagger TrainFromFile(StreamReader reader)
        {
            var result = new PoSTagger();

            while(!reader.EndOfStream)
            {
                var line = reader.ReadLine();



                //wordDictionary.AddToTag(reader.ReadLine());
                //tagWords.Add(reader.ReadLine());
            }

            return result;
        }

        public string TagSentence(string sentence)
        {
            return sentence;
        }
    }
}

