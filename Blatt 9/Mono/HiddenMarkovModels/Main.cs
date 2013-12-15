using System;
using System.IO;

namespace HiddenMarkovModels
{
    class MainClass
    {
        public static void Main (string[] args)
        {
            PoSTagger tagger = null;

            try
            {
				var reader = new StreamReader(@"heiseticker-tags.txt");

                tagger = PoSTagger.TrainFromFile(reader);
            }
            catch(IOException)
            {
                Console.WriteLine("File not found.");
                return;
            }

            string input;
            do
            {
				Console.Write("Enter Sentence: ");
                input = Console.ReadLine();

                Console.WriteLine(tagger.TagSentence(input));
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
