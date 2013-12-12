using System;
using System.Collections.Generic;

namespace HiddenMarkovModels
{
	public class TagDictionary
	{
		private Dictionary<string, HashSet<string>> dict1;
		private Dictionary<string, List<string>> dict2;
		private Random rand;
		

		public TagDictionary()
		{
			dict1 = new Dictionary<string, HashSet<string>>();
		}

		public void Add(string word, string tag)
		{
			try
			{
				dict1[tag].Add(word);
			}
			catch
			{
				dict1.Add(tag, new HashSet<string>());
				dict1[tag].Add(word);
			}
		}

		public void Process()
		{
			dict2 = new Dictionary<string, List<string>>();
			foreach(var tag in dict1)
			{
				dict2.Add(tag.Key, new List<string>(tag.Value));
			}
            rand = new Random();
		}

		public string GetRandomWordForTag(string tag)
		{
			if(dict2 == null) return "{{TagDictionary not processed}}";
			try
			{
				var words = dict2[tag];
				return words[rand.Next(words.Count)];
			}
			catch
			{
				return "{{unknown tag}}";
			}
		}
	}
}

