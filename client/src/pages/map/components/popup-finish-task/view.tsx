import React from "react";

interface PopupFinishTaskProps {
  isPopup: boolean,
  handle: () => void
}

export const PopupFinishTask: React.FC<PopupFinishTaskProps> = (props) => {
  const { isPopup, handle } = props;
  return (
    <div
      className={` duration-500 ${
        isPopup ? "" : "hidden"
      } h-screen w-screen absolute top-0 bg-black/[.3] flex justify-center items-center`}
    >
      <div className="w-[300px] h-[150px] bg-slate-200 flex flex-col justify-center items-center gap-5 border rounded">
        <div>
          <span className="text-3xl">Вы уверены ?</span>
        </div>
        <div>
          <button
            className="w-[70px] p-2 mr-5 border border-orange-400 bg-orange-400 rounded duration-500 hover:bg-inherit active:bg-orange-900"
            onClick={handle}
          >
            Да
          </button>
          <button
            className="w-[70px] p-2 border border-red-400 rounded duration-500 hover:bg-red-600"
            onClick={handle}
          >
            Нет
          </button>
        </div>
      </div>
    </div>
  );
};
