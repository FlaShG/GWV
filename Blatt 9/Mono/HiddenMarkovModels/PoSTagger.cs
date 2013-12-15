
using System;
using System.IO;
using System.Text;

namespace HiddenMarkovModels
{
    public class PoSTagger
    {
        private TagDictionary markovChains = new TagDictionary();
        private TagDictionary wordsForTags = new TagDictionary();
        private TagDictionary tagsForWords = new TagDictionary();

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
                    markovChains.AddToTag(previousTag, tag); //store following tag to tag
                }
                tagsForWords.AddToTag(word, tag);

                
                previousTag = tag;
            }
        }

        public static PoSTagger TrainFromFile(StreamReader reader)
        {
            return new PoSTagger(reader);
        }

        public string TagSentence(string sentence)
        {
            var split = sentence.Split(new char[]{' '});

            var result = new StringBuilder();

            String tag = null;
            foreach(var word in split)
            {
                result.Append(word);
                result.Append("\\");
                tag = TagForWord(word, tag);
                result.Append(tag != null ? tag : "???");
                result.Append(" ");
            }

            return result.ToString();
        }

        public String TagForWord(string word, String previousTag = null)
        {
            ProbabilityDictionary<string> possibleTags = null;
            try
            {
                possibleTags = tagsForWords.GetProbabilityDictionaryFor(word);
            } catch {}


            try
            {
                if(possibleTags != null)
                {
                    if(possibleTags.Count == 1)
                    {
                        //Only one tag is possible for this word. Return that.
                        return possibleTags.GetRandomItem();
                    }
                    else
                    {
                        //Multiple possible tags. Choose with help of markov chains.
                        try
                        {
                            return markovChains.GetProbabilityDictionaryFor(previousTag).GetItemWithHighestProbablity();
                        }
                        catch
                        {
                            return possibleTags.GetItemWithHighestProbablity();
                        }
                    }
                }
                else
                {
                    //No possible tags known. Rely on markov chains only.
                    //Console.WriteLine(markovChains.GetProbabilityDictionaryFor(previousTag));
                    return markovChains.GetProbabilityDictionaryFor(previousTag).GetItemWithHighestProbablity();
                }
            }
            catch(Exception e)
            {
                //Console.WriteLine(e.StackTrace);
                return null;
            }
        }
    }
}

