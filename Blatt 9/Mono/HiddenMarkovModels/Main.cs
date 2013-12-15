using System;
using System.Collections.Generic;
using System.IO;

namespace HiddenMarkovModels
{
    class MainClass
    {
        public static void Main (string[] args)
        {
            var wordDictionary = new TagDictionary();

            try
            {
				var reader = new StreamReader(@"heiseticker-tags.txt");

                while(!reader.EndOfStream)
                {
                    wordDictionary.AddTag(reader.ReadLine());
                    //tagWords.Add(reader.ReadLine());
                }
            }
            catch(IOException)
            {
                Console.WriteLine("File not found.");
                return;
            }

            string input;
            do
            {
				Console.Write("Enter Word: ");
                input = Console.ReadLine();

                Console.WriteLine(wordDictionary.GetAllTags(input));
				//Console.WriteLine(tagWords.GetRandomWordForTag(input));

            }while(input != "exit");



            /*
            Console.Write("Enter a Word thing: ");
            string input = Console.ReadLine();
            Console.WriteLine("You said dat: "+input);
            */
        }

        //private 
    }
}
