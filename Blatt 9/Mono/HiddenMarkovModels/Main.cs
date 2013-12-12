using System;
using System.Collections.Generic;
using System.IO;

namespace HiddenMarkovModels
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			var tagWords = new Dictionary<string, HashSet<string>>();

			try
			{
				var reader = new StreamReader("heiseticker-tags.txt");

				while(!reader.EndOfStream)
				{
					//reader.ReadLine()
				}
			}
			catch
			{
				Console.WriteLine("File not found.");
				return;
			}


			/*
			Console.Write("Enter a Word thing: ");
			string input = Console.ReadLine();
			Console.WriteLine("You said dat: "+input);
			*/
		}

		//private 
	}
}
