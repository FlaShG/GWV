
using System;
using System.Collections.Generic;
using System.Text;

namespace HiddenMarkovModels
{
    public class ProbabilityDictionary<T>
    {
        private Dictionary<T, int> dict;
        public int Count{ private set; get; }
        private int totalCount = 0;
        private Random rand;


        public ProbabilityDictionary()
        {
            dict = new Dictionary<T, int>();
            rand = new Random();
        }

        public ProbabilityDictionary(ProbabilityDictionary<T> original)
        {
            dict = original.dict;
            Count = original.Count;
            totalCount = original.totalCount;
            rand = new Random();
        }

        public void Add(T item)
        {
            try
            {
                ++dict[item];
            }
            catch
            {
                dict.Add(item, 1);
                ++Count;
            }


            ++totalCount;
        }

        public T GetRandomItem()
        {
            int num = rand.Next(totalCount);

            foreach(var pair in dict)
            {
                num -= pair.Value;
                if(num < 0)
                {
                    return pair.Key;
                }
            }

            return default(T);
        }

        public T GetItemWithHighestProbablity()
        {
            KeyValuePair<T, int> max = new KeyValuePair<T, int>(default(T), 0);

            foreach(var pair in dict)
            {
                if(pair.Value > max.Value)
                {
                    max = pair;
                }
            }

            return max.Key;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();

            bool first = true;
            foreach(var t in dict)
            {
                if(!first)
                {
                    builder.Append(", ");
                }
                else
                {
                    first = false;
                }

                builder.AppendFormat("{0}: {1}", t.Key, (1f * t.Value) / totalCount);
            }

            return builder.ToString();
        }
    }
}

