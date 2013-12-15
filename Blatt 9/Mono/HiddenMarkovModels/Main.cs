using System;
using System.Collections.Generic;
using System.IO;

namespace HiddenMarkovModels
{
    class MainClass
    {
        public static void Main (string[] args)
        {
            try
            {
				var reader = new StreamReader(@"heiseticker-tags.txt");

                var tagger = PoSTagger.TrainFromFile(reader);
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

                Console.WriteLine(PoSTagger.TagSentence(input));
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
