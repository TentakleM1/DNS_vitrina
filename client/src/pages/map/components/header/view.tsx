import React from "react";
import { useNavigate } from "react-router-dom";

interface HeaderProps {
  isTask: boolean;
  isStuff: boolean;
  handle: (click: string) => void;
}

export const Header: React.FC<HeaderProps> = (props) => {
  const { isTask, isStuff, handle } = props;
  const navigate = useNavigate();

  return (
    <header className="z-50 flex justify-between items-center p-6 bg-[#ff7235]">
      <section>
        <span className="text-white text-5xl font-bold">Витрина</span>
      </section>
      <section className="flex items-center gap-8">
        <section>
          <button className="w-14">
            <img
              src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
              className="rounded-full"
              alt=""
            />
          </button>
        </section>
        <nav>
          <ul className="text-white">
            <li className="inline-block mr-4">
              <button
                className="
                btn-header
                border
                border-[#5a578b] 
                rounded-3xl p-2 
                bg-none 
                duration-700
                hover:bg-[#5a578b]
                hover:scale-110
              "
                onClick={() => handle("stuff")}
              >
                {isStuff ? "Карта" : "Создать сотрудника"}
              </button>
            </li>
            <li className="inline-block  mr-4">
              <button
                className="
                btn-header
                border
                border-[#5a578b] 
                rounded-3xl p-2 
                bg-none 
                duration-700
                hover:bg-[#5a578b] 
                hover:scale-110
              "
                onClick={() => handle("task")}
              >
                {isTask ? "Карта" : "Создать задачу"}
              </button>
            </li>
            <li className="inline-block">
              <button
                className="
                btn-header
                border
                border-[#9b2f00] 
                rounded-3xl p-2 
                bg-none 
                duration-700
                hover:bg-[#9b2f00]
                hover:scale-110
              "
                onClick={() => navigate("/")}
              >
                Выйти
              </button>
            </li>
          </ul>
        </nav>
      </section>
    </header>
  );
};
