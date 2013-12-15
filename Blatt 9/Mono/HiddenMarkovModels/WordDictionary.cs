
using System;
using System.Collections.Generic;

namespace HiddenMarkovModels
{
    public class WordDictionary
    {
        //                  word                          tags
        private Dictionary<string, ProbabilityDictionary<string>> dict;

        public WordDictionary ()
        {
            dict = new Dictionary<string, ProbabilityDictionary<string>>();
        }

        public void AddTagToWord(string line)
        {
            var split = line.Split(new char[]{'\t'}, 2);
            if(split.Length == 2)
            {
                AddTagToWord(split[0].Trim (), split[1].Trim());
            }
        }

        public void AddTagToWord(string word, string tag)
        {
            try
            {
                dict[word].Add(tag);
            }
            catch
            {
                dict.Add(word, new ProbabilityDictionary<string>());
                dict[word].Add(tag);
            }
        }

        public string GetTagForWord(string word, TagChains chains)
        {
            ProbabilityDictionary <string> possibleTags;
            try
            {
                possibleTags = dict[word];
            } catch {  }

            if(possibleTags != null)
            {
                if(possibleTags.Count == 1)
                {
                    //Only one tag is possbile. Return that one.
                    return possibleTags.GetRandomItem();
                }
                else
                {
                    //Multiple tags could be possible.
                    //Use markov chains and tag probability to nominate a tag.

                }
            }
            else
            {
                //Any tag could be possible. Rely on markov chains only.

            }

            return "{{ goddamit steve }}";
        }

        public string GetAllTagsForWord(string word)
        {
            try
            {
                return dict[word].ToString();
            }
            catch
            {
                return "{{ unknown word }}";
            }
        }
    }
}

