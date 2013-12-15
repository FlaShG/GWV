
using System;
using System.Collections.Generic;

namespace HiddenMarkovModels
{
    public class TagDictionary
    {
        //                    tag  , predecessor tags / words for that tag
        protected Dictionary<string, ProbabilityDictionary<string>> dict;

        public TagDictionary ()
        {
            dict = new Dictionary<string, ProbabilityDictionary<string>>();
        }

        public void AddToTag(string tag, string wordToAdd)
        {
            try
            {
                dict[tag].Add(wordToAdd);
            }
            catch
            {
                dict.Add(tag, new ProbabilityDictionary<string>());
                dict[tag].Add(wordToAdd);
            }
        }

        public string GetAllWords(string tag)
        {
            try
            {
                return dict[tag].ToString();
            }
            catch
            {
                return "{{ unknown tag }}";
            }
        }
    }
}

