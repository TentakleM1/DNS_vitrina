import React, { useState } from "react";
import { PopupFinishTask } from "../popup-finish-task";

export const Footer: React.FC = () => {
  const [isPopup, setIsPopup] = useState(false)

  const handle = () => {
    setIsPopup(!isPopup)
  }

  return (  
    <footer className="border border-t-orange-500">
      <PopupFinishTask isPopup={isPopup} handle={handle} />
      <div className="h-[150px] m-2 p-2 overflow-x-scroll overflow-y-hidden flex flex-row gap-1">
        <section className="border rounded flex-none w-[200px] p-2 cursor-pointer duration-500 hover:shadow-lg" onClick={handle}>
          <h1>Витрина КБТ:</h1>
          <p>Выстовить товар со склада</p>
          <time>04.08.2024</time>
        </section>
      </div>
      <div className="bg-slate-900 text-slate-300 flex justify-center p-1">
        <span>creaty by martynenko and golotkyn 2024</span>
      </div>
    </footer>
  );
};
