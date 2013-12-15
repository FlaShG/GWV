
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

        public string GetTagsForWord(string word)
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

