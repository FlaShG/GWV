//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.1008
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------
using System;
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
            while(!reader.EndOfStream)
            {
                //wordDictionary.AddToTag(reader.ReadLine());
                //tagWords.Add(reader.ReadLine());
            }
        }

        public string TagSentence(string sentence)
        {
            return sentence;
        }
    }
}
