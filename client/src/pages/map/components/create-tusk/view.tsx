import React, { useState } from "react";
import { useSelector } from "../../../../shared/store/store";

const tasks = [
  "актуальность термака",
  "проверить воблеры",
  "вытиреть витрину",
  "сделать мерч",
];
const storefronts = ["КБТ", "Мониторы", "Аудио", "Смартфоны"];

export const CreateTusk: React.FC = () => {
  const [name, setName] = useState("none");
  const [storefront, setStorefront] = useState("none");
  const [task, setTask] = useState("none");
  const { stuff } = useSelector((state) => state);

  const choiceUsm = (index: number) => {
    stuff.stuff.forEach((usm) => {
      if (usm.id == index) {
        setName(`${usm.lastName} ${usm.name}`);
      }
    });
  };

  const choiceStorefront = (index: number) => {
    setStorefront(storefronts[index]);
  };

  const choiceTask = (index: number) => {
    setTask(tasks[index]);
  };

  return (
    <div className="h-[400px] w-full flex justify-around">
      <div className="h-[400px]  p-2 overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
        {stuff.stuff.map((card) => {
          if (card.root) return;
          return (
            <section
              key={card.id}
              onClick={() => choiceUsm(card.id)}
              className="w-[300px] h-[100px] flex-none flex flex-col items-center gap-2 overflow-hidden border border-orange-500 cursor-pointer rounded-xl duration-500 hover: hover:shadow-lg hover:bg-orange-500 hover:text-amber-50"
            >
              <div className="flex justify-center items-center">
                <div className="w-20 h-20 m-2">
                  <img
                    src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
                    alt="usm"
                    className="rounded-full"
                  />
                </div>
                <div>
                  <span>{`${card.lastName} ${card.name}`}</span>
                </div>
              </div>
            </section>
          );
        })}
      </div>
      <section className="h-full w-[500px] flex flex-row justify-around gap-2 items-center p-2 bg-[#ff7235] rounded-3xl">
        <div className="h-full w-[50%] border-r-4 border-[#5a578b] flex justify-center">
          <ul className="text-amber-50">
            {storefronts.map((item, index) => {
              return (
                <li onClick={() => choiceStorefront(index)} className="m-2">
                  <button
                    className="
                      w-[100px] 
                      border
                      border-[#5a578b] 
                      rounded-3xl p-2 
                      bg-none 
                      duration-700
                    hover:bg-[#5a578b]
                      hover:scale-110"
                  >
                    {item}
                  </button>
                </li>
              );
            })}
          </ul>
        </div>
        <div className="h-full w-[50%] flex justify-center">
          <ul className="text-amber-50">
            {tasks.map((task, index) => {
              return (
                <li onClick={() => choiceTask(index)} className="m-2">
                  <button
                    className="
                      w-[200px]
                      border
                      border-[#5a578b] 
                      rounded-3xl p-2 
                      bg-none 
                      duration-700
                    hover:bg-[#5a578b]
                      hover:scale-110"
                  >
                    {task}
                  </button>
                </li>
              );
            })}
          </ul>
        </div>
      </section>
      <section className="h-full w-[300px] flex flex-col justify-between rounded-3xl bg-[#5a578b]">
        <div className="h-[200px] p-2">
          <div className="h-[150px] bg-[#ff7235] p-2 rounded-2xl text-amber-50">
            <h1>УСМ: {name}</h1>
            <h3>Витрина: {storefront}</h3>
            <span>Задача: {task}</span>
          </div>
        </div>
        <div className="h-[70px] p-2 flex justify-end">
          <div>
            <button className="text-amber-50 rounded-3xl p-2 duration-500 hover:bg-orange-500 hover:scale-110">
              Сохранить
            </button>
          </div>
        </div>
      </section>
    </div>
  );
};
