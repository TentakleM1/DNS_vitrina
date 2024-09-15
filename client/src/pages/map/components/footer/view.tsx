import React, { useState } from "react";
import { PopupFinishTask } from "../popup-finish-task";

interface FooterProps {
  isOpen: boolean
}

export const Footer: React.FC<FooterProps> = (props) => {
  const { isOpen } = props;
  const [isPopup, setIsPopup] = useState(false);

  const handle = () => {
    setIsPopup(!isPopup);
  };

  return (
    <footer className="text-slate-100  font-bold">
      {isOpen ? (
        <></>
      ) : (
        <>
          <PopupFinishTask isPopup={isPopup} handle={handle} />
          <div className="h-[150px] m-2 p-2 overflow-x-scroll overflow-y-hidden flex flex-row gap-3">
            <section
              className="bg-[#393378] rounded-3xl flex-none w-[200px] p-3 cursor-pointer duration-500 hover:scale-110"
              onClick={handle}
            >
              <h1>Витрина КБТ:</h1>
              <p>Выстовить товар со склада</p>
              <time>04.08.2024</time>
            </section>
          </div>
        </>
      )}
      <div className="flex justify-center">
        <span>creaty by martynenko and golotkyn 2024</span>
      </div>
    </footer>
  );
};
