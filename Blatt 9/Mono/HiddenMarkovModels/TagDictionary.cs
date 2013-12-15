
using System;
using System.Collections.Generic;

namespace HiddenMarkovModels
{
    public class TagDictionary
    {
        //                    tag  ,  successor tags / words for that tag
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

        public ProbabilityDictionary<string> GetProbabilityDictionaryFor(string tag)
        {
            try
            {
                return new ProbabilityDictionary<string>(dict[tag]);
            }
            catch
            {
                return null;
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

