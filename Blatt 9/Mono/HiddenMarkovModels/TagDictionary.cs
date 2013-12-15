
using System;
using System.Collections.Generic;

namespace HiddenMarkovModels
{
    public class TagDictionary
    {
        //                  word/tag                        tags
        protected Dictionary<string, ProbabilityDictionary<string>> dict;

        public TagDictionary ()
        {
            dict = new Dictionary<string, ProbabilityDictionary<string>>();
        }

        public void AddTag(string line)
        {
            var split = line.Split(new char[]{'\t'}, 2);
            if(split.Length == 2)
            {
                AddTag(split[0].Trim (), split[1].Trim());
            }
        }

        public void AddTag(string word, string tag)
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

        public string GetAllTags(string word)
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

