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

                while(!reader.EndOfStream)
                {
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
				Console.Write("Enter Tag: ");
                input = Console.ReadLine();

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
