
using System;
using System.IO;

namespace HiddenMarkovModels
{
    public class PoSTagger
    {
        private TagDictionary markovChains = new TagDictionary();
        private TagDictionary wordsForTags = new TagDictionary();

        private PoSTagger(StreamReader reader)
        {
            string word;
            string tag;
            String previousTag = null;
            
            while(!reader.EndOfStream)
            {
                var line = reader.ReadLine();
                
                var split = line.Split(new char[]{'\t'}, 2);
                if(split.Length != 2)
                {
                    continue;
                }
                
                word = split[0];
                tag = split[1];
                
                
                wordsForTags.AddToTag(tag, word);
                if(previousTag != null)
                {
                    markovChains.AddToTag(tag, previousTag);
                }
                
                
                previousTag = tag;
            }
        }

        public static PoSTagger TrainFromFile(StreamReader reader)
        {
            return new PoSTagger(reader);
        }

        public string TagSentence(string sentence)
        {
            return sentence;
        }
    }
}

